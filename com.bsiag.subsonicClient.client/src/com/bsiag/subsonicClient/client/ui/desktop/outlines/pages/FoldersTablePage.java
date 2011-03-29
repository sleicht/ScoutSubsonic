package com.bsiag.subsonicClient.client.ui.desktop.outlines.pages;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.scout.commons.CollectionUtility;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractObjectColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.subsonic.restapi.Index;
import org.subsonic.restapi.Indexes;
import org.subsonic.restapi.Response;

import com.bsiag.subsonicClient.shared.Texts;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class FoldersTablePage extends AbstractPageWithTable<FoldersTablePage.Table> {

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("Index");
  }

  @Override
  protected IPage execCreateChildPage(ITableRow row) throws ProcessingException {
    ArtistTablePage childPage = new ArtistTablePage((Index) row.getKeyValues()[0]);
    return childPage;

  }

  @Override
  protected Object[][] execLoadTableData(SearchFilter filter) throws ProcessingException {
    List<Object[]> tableData = null;
    Indexes indexes = getData();
    for (Index index : indexes.getIndex()) {
      List<Object> rowData = null;
      rowData = CollectionUtility.appendList(rowData, index);
      rowData = CollectionUtility.appendList(rowData, index.getName());

      tableData = CollectionUtility.appendList(tableData, CollectionUtility.toArray(rowData, Object.class));
    }
    return CollectionUtility.toArray(tableData, Object[].class);
  }

  private Indexes getData() {
    String GET_INDEXES = "getIndexes.view";//?u=admin&p=tower22&v=1.4.0&c=scoutSubsonic&f=json";

    String GET_USER = "admin";
    String GET_PW = "tower22";
    String GET_VERSION = "1.4.0";
    String GET_CLIENT = "scoutSubsonic";
    String GET_FORMAT = "xml";

    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(getBaseURI());
    // Get XML
    WebResource getIndex = service.path("rest").path(GET_INDEXES);
    getIndex = getIndex
        .queryParam("u", GET_USER)
        .queryParam("p", GET_PW)
        .queryParam("v", GET_VERSION)
        .queryParam("c", GET_CLIENT)
        .queryParam("f", GET_FORMAT);
    Response response = getIndex.accept(MediaType.APPLICATION_XML).get(Response.class);

    System.out.println(response.getStatus().toString());
    System.out.println(response.getVersion());
    return response.getIndexes();
  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri(
        "http://localhost:808/").build();
  }

  @Order(10.0)
  public class Table extends AbstractTable {

    @Override
    protected boolean getConfiguredAutoResizeColumns() {
      return true;
    }

    public IndexColumn getIndexColumn() {
      return getColumnSet().getColumnByClass(IndexColumn.class);
    }

    public NameColumn getNameColumn() {
      return getColumnSet().getColumnByClass(NameColumn.class);
    }

    @Order(10.0)
    public class IndexColumn extends AbstractObjectColumn {

      @Override
      protected boolean getConfiguredDisplayable() {
        return false;
      }

      @Override
      protected boolean getConfiguredPrimaryKey() {
        return true;
      }
    }

    @Order(20.0)
    public class NameColumn extends AbstractStringColumn {

      @Override
      protected boolean getConfiguredAlwaysIncludeSortAtBegin() {
        return true;
      }

      @Override
      protected String getConfiguredHeaderText() {
        return Texts.get("Index");
      }
    }
  }
}
