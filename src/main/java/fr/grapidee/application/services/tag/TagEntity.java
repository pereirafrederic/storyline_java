package fr.grapidee.application.services.tag;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.grapidee.application.services.commun.CommunEntity;

@Entity(name="tag")
@Table(name = "tag", schema = "grapidee")
public class TagEntity extends CommunEntity {
	private static final long serialVersionUID = 1L;
	
}
