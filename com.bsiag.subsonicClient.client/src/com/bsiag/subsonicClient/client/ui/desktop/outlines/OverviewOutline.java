package com.bsiag.subsonicClient.client.ui.desktop.outlines;

import java.util.Collection;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.shared.TEXTS;

import com.bsiag.subsonicClient.client.ui.desktop.outlines.pages.FoldersTablePage;

public class OverviewOutline extends AbstractOutline {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Overview");
  }

  @Override
  protected void execCreateChildPages(Collection<IPage> pageList) throws ProcessingException {
    FoldersTablePage foldersTablePage = new FoldersTablePage();
    pageList.add(foldersTablePage);
  }
}
