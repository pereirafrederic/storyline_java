package utils.comparator;

import java.util.Comparator;
import java.util.List;

import fr.grappe.idee.application.model.entity.AssociationEntity;
import fr.grappe.idee.application.model.entity.GrappeEntity;
import fr.grappe.idee.application.model.entity.IdeeEntity;

public abstract class ComparatorSort {

	public static List<GrappeEntity> getGrappeSortByNom(List<GrappeEntity> liste) {

		Comparator<GrappeEntity> byName = new Comparator<GrappeEntity>() {
			@Override
			public int compare(GrappeEntity o1, GrappeEntity o2) {
				return o1.getNom().compareTo(o2.getNom());
			}
		};
		liste.sort(byName);

		return liste;
	}
	
	
	public static List<AssociationEntity> getIdeeSortByGrappe(List<AssociationEntity> liste) {

		Comparator<AssociationEntity> byName = new Comparator<AssociationEntity>() {
			@Override
			public int compare(AssociationEntity o1, AssociationEntity o2) {
				return o1.getGrappe().getNom().compareTo(o2.getGrappe().getNom());
			}
		};
		liste.sort(byName);

		return liste;
	}

}
