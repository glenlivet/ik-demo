package org.ikgroup.editor;

import java.beans.PropertyEditorSupport;

import org.ikgroup.domain.BindingProperty;

public class BindingPropertyEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(new BindingProperty(text));
	}

}
