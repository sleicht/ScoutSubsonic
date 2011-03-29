package com.bsiag.subsonicClient.client.ui.desktop.outlines.pages;

import java.util.List;

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
import org.subsonic.restapi.Artist;
import org.subsonic.restapi.Index;

import com.bsiag.subsonicClient.shared.Texts;

public class ArtistTablePage extends AbstractPageWithTable<ArtistTablePage.Table> {

  private final Index m_index;

  /**
   * @param index
   */
  public ArtistTablePage(Index index) {
    m_index = index;
  }

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("Artist");
  }

  @Override
  protected IPage execCreateChildPage(ITableRow row) throws ProcessingException {
    DirectoryTablePage childPage = new DirectoryTablePage((String) row.getKeyValues()[1]);
    return childPage;

  }

  @Override
  protected Object[][] execLoadTableData(SearchFilter filter) throws ProcessingException {
    List<Object[]> tableData = null;
    for (Artist artist : m_index.getArtist()) {
      List<Object> rowData = null;
      rowData = CollectionUtility.appendList(rowData, artist);
      rowData = CollectionUtility.appendList(rowData, artist.getId());
      rowData = CollectionUtility.appendList(rowData, artist.getName());

      tableData = CollectionUtility.appendList(tableData, CollectionUtility.toArray(rowData, Object.class));
    }
    return CollectionUtility.toArray(tableData, Object[].class);
  }

  @Order(10.0)
  public class Table extends AbstractTable {

    @Override
    protected boolean getConfiguredAutoResizeColumns() {
      return true;
    }

    public ArtistColumn getArtistColumn() {
      return getColumnSet().getColumnByClass(ArtistColumn.class);
    }

    public ArtistIdColumn getArtistIdColumn() {
      return getColumnSet().getColumnByClass(ArtistIdColumn.class);
    }

    public ArtistObjColumn getArtistObjColumn() {
      return getColumnSet().getColumnByClass(ArtistObjColumn.class);
    }

    @Order(10.0)
    public class ArtistObjColumn extends AbstractObjectColumn {

      @Override
      protected boolean getConfiguredDisplayable() {
        return false;
      }

      @Override
      protected boolean getConfiguredPrimaryKey() {
        return true;
      }

      @Override
      protected int getConfiguredWidth() {
        return 60;
      }
    }

    @Order(20.0)
    public class ArtistIdColumn extends AbstractStringColumn {

      @Override
      protected boolean getConfiguredDisplayable() {
        return false;
      }

      @Override
      protected boolean getConfiguredPrimaryKey() {
        return true;
      }

      @Override
      protected int getConfiguredWidth() {
        return 60;
      }
    }

    @Order(30.0)
    public class ArtistColumn extends AbstractStringColumn {

      @Override
      protected String getConfiguredHeaderText() {
        return Texts.get("Artist");
      }

      @Override
      protected int getConfiguredWidth() {
        return 409;
      }
    }
  }
}
