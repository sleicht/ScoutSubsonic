package com.bsiag.subsonicClient.client.ui.desktop.outlines;

import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;

import com.bsiag.subsonicClient.shared.Texts;
import java.util.Collection;
import com.bsiag.subsonicClient.client.ui.desktop.outlines.pages.FoldersTablePage;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;

public class OverviewOutline extends AbstractOutline {

  @Override
  protected String getConfiguredTitle() {
    return Texts.get("Overview");
  }

  @Override
  protected void execCreateChildPages(Collection<IPage> pageList) throws ProcessingException {
  FoldersTablePage foldersTablePage = new FoldersTablePage();
    pageList.add(foldersTablePage);
  
  }
}
