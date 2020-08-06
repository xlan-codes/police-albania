package com.vesa.wazeapi.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "police")
public class PoliceEntity extends BaseAlertEntity {

}
