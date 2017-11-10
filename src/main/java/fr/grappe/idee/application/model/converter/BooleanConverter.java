package fr.grappe.idee.application.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanConverter implements AttributeConverter<Boolean, Integer> {

		  @Override
		  public Integer convertToDatabaseColumn(Boolean attribute) {
		    if (attribute!=null && attribute) {
		      return 1;
		    } else {
		      return 0;
		    }
		  }

		  @Override
		  public Boolean convertToEntityAttribute(Integer dbData) {
		    if (null != dbData) {
		      return dbData.equals(1);
		    } else {
		      return false;
		    }
		  }
		}