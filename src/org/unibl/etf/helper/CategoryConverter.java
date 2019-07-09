package org.unibl.etf.helper;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.unibl.etf.dto.Category;

@FacesConverter("customCategoryConverter")
public class CategoryConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent cmp, String strValue) {
		FacesMessage errorMessage = new FacesMessage("Category Conversion error.", "Invalid format.");
		errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		
		Category category = new Category();
		
		if (strValue != null) {
			try {
				String[] values = strValue.split("\\|\\|");
				
				if (values.length != 2) {
					throw new Exception();
				}
				
				category.setId(Integer.valueOf(values[0]));
				category.setName(values[1]);
				
			} catch (Exception e) {
				throw new ConverterException(errorMessage);
			}
			
		} else {
			throw new ConverterException(errorMessage);
		}
		
		return category;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent cmp, Object obj) {
		FacesMessage errorMessage = new FacesMessage("Category Conversion error.", "Invalid format.");
		errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		
		String stringValue = "";
		
		if (obj != null || !(obj instanceof Category)) {
			stringValue = ((Category) obj).getId() + "||" + ((Category) obj).getName();
		} else {
			throw new ConverterException(errorMessage);
		}
		
		return stringValue;
	}

}
