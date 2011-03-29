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
import org.eclipse.scout.rt.shared.ScoutTexts;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.subsonic.restapi.Child;
import org.subsonic.restapi.Directory;
import org.subsonic.restapi.Response;

import com.bsiag.subsonicClient.shared.Texts;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class DirectoryTablePage extends AbstractPageWithTable<DirectoryTablePage.Table> {

  private final String m_id;

  /**
   * @param string
   */
  public DirectoryTablePage(String id) {
    m_id = id;
  }

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("Directory");
  }

  @Override
  protected IPage execCreateChildPage(ITableRow row) throws ProcessingException {
    Child child = (Child) row.getKeyValues()[0];
    Directory directory = getData(child.getId());
    List<Child> childs = directory.getChild();
    if (childs != null && childs.size() > 0 && directory.getChild().get(0).isIsDir()) {
      DirectoryTablePage childPage = new DirectoryTablePage(child.getId());
      return childPage;
    }
    else {
      TrackTablePage childPage = new TrackTablePage(child.getId());
      return childPage;
    }
  }

  @Override
  protected Object[][] execLoadTableData(SearchFilter filter) throws ProcessingException {
    List<Object[]> tableData = null;
    Directory directory = getData(m_id);
    for (Child child : directory.getChild()) {
      List<Object> rowData = null;
      rowData = CollectionUtility.appendList(rowData, child);
      rowData = CollectionUtility.appendList(rowData, child.getTitle());

      tableData = CollectionUtility.appendList(tableData, CollectionUtility.toArray(rowData, Object.class));
    }
    return CollectionUtility.toArray(tableData, Object[].class);
  }

  private Directory getData(String id) {
    String GET_MUSIC_DIRECTORY = "getMusicDirectory.view";

    String GET_USER = "admin";
    String GET_PW = "tower22";
    String GET_VERSION = "1.4.0";
    String GET_CLIENT = "scoutSubsonic";
    String GET_FORMAT = "xml";

    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(getBaseURI());
    // Get XML
    WebResource getMusicDirectory = service.path("rest").path(GET_MUSIC_DIRECTORY);
    getMusicDirectory = getMusicDirectory
        .queryParam("u", GET_USER)
        .queryParam("p", GET_PW)
        .queryParam("v", GET_VERSION)
        .queryParam("c", GET_CLIENT)
        .queryParam("f", GET_FORMAT);

    getMusicDirectory = getMusicDirectory.queryParam("id", id);
    Response response = getMusicDirectory.accept(MediaType.APPLICATION_XML).get(Response.class);

    System.out.println(response.getStatus().toString());
    System.out.println(response.getVersion());
    return response.getDirectory();
  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost:808/").build();
  }

  @Order(10.0)
  public class Table extends AbstractTable {

    public TitleColumn getTitleColumn() {
      return getColumnSet().getColumnByClass(TitleColumn.class);
    }

    @Override
    protected boolean getConfiguredAutoResizeColumns() {
      return true;
    }

    public ChildColumn getChildColumn() {
      return getColumnSet().getColumnByClass(ChildColumn.class);
    }

    @Order(10.0)
    public class ChildColumn extends AbstractObjectColumn {

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
    public class TitleColumn extends AbstractStringColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return ScoutTexts.get("Title");
      }
    }
  }
}
