package com.vesa.wazeapi.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "trafficjam")
public class TrafficJamEntity extends BaseAlertEntity {
}
