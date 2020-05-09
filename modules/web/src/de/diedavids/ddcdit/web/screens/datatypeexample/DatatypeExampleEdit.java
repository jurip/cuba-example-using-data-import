package de.diedavids.ddcdit.web.screens.datatypeexample;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.ddcdit.entity.DatatypeExample;

@UiController("ddcdit_DatatypeExample.edit")
@UiDescriptor("datatype-example-edit.xml")
@EditedEntityContainer("datatypeExampleDc")
@LoadDataBeforeShow
public class DatatypeExampleEdit extends StandardEditor<DatatypeExample> {
}