# X-Road Services Introduction

## Interfaces

### Message Protocols

The X-Road Message Protocol is used by service client and service provider information systems for communicating with the X-Road Security Server.

X-Road supports two message protocols: message protocol for SOAP and message protocol for REST. Both protocols are synchronous, and they're initiated by the client IS or by the service provider's Security Server.

### Service Metadata Protocol

The X-Road Service Metadata Protocol can be used by the service client information systems to gather information about the X-Road instance. In particular, the protocol can be used to find X-Road members, services offered by these members and the WSDL / OpenAPI 3 service descriptions.

The X-Road Service Metadata Protocol has two versions: one for SOAP and another one for REST. The SOAP version provides information about the available SOAP services only and similarly, the REST version contain information about the available REST services only. This means that in case information about all the available SOAP and REST services needs to be collected, both SOAP and REST versions of the metaservices must be invoked.

The protocol is synchronous RPC style protocol that is initiated by the service client IS.

### Downloading Signed Documents

The signed document download service can be used by the information systems to download signed ASiC containers from the Security Server's message log. The containers can be transferred to third parties and verified offline. In addition, the service provides a convenience method for downloading global configuration that is required for verifying the containers.

The containers can be verified using the signed document verification tool - the asicverifier command line utility. The asicverifier utility is shipped with the Security Server and in addition to the verification, it can be used to extract signed files from the containers.

The protocol is a synchronous RPC-style protocol that is initiated by the IS.

### Operational Monitoring Data

The X-Road Operational Monitoring Protocol can be used by the external monitoring systems to gather operational information of the Security Server. The protocol is synchronous RPC style protocol that is initiated by the external monitoring system.

Operational monitoring collects data about request exchange between Security Servers. The data includes, but is not limited to:

* ID-s of the client and the service
* various attributes of the message read from the message header
* request and response timestamps
* message size and processing time

### Environmental Monitoring Protocol

The Environmental Monitoring Protocol can be used by the external monitoring systems to gather environmental monitoring information about the Security Server.

Both environmental and operational monitoring queries are allowed from

* a client that is the owner of the Security Server
* a central monitoring client (if any have been configured)

In addition, a regular client is allowed to query its own operational monitoring records - records that are associated with the client sending the query.

## Data Exchange

X-Road Message Protocols and X-Road Transport Protocol form the core of the X-Road data exchange:

* Message Protocols are used by service client and service provider information systems for communicating with the X-Road Security Server. X-Road provides a message protocol for SOAP and a message protocol for REST.
* Message Transport Protocol is used by Security Server to exchange service requests and service responses. The protocol is based on HTTPS and uses mutual certificate-based TLS authentication.

Message routing is based on the identifiers that are mapped to physical network locations of the services by X-Road. The basic idea is that the information system sending the request and the service that is invoked are specified using the identifiers. The identifiers are included in SOAP headers (SOAP) or HTTP headers (REST) depending on the message protocol that is used. In addition to the identifiers specifying the sender and receiver of the message, the headers may be used to carry additional information, too.

## Message Headers

Message routing is based on the identifiers that are mapped to physical network locations of the services by X-Road. The basic idea is that the information system sending the request and the service that is invoked are specified using the identifiers. The identifiers are included in SOAP headers (SOAP) or HTTP headers (REST) depending on the message protocol that is used. In addition to the identifiers specifying the sender and receiver of the message, the headers may be used to carry additional information, too.

## Metadata Services

The Security Server provides a set of methods that can be used by X-Road participants to discover what services are available to them and download the machine readable service descriptions. These methods are known as metadata services and they are accessed using the service metadata protocol for SOAP and the service metadata protocol for REST. The available metadata service are:

* listClients - a list of X-Road members and subsystems. (SOAP / REST)
* listCentralServices - a list of all central services defined in an X-Road instance. (SOAP)
* listMethods - a list of all services provided by the specified service provider. (SOAP / REST)
* listAllowedMethods - a list of services provided by the specified service provider that the caller has permission to invoke. (SOAP / REST)
* getWsdl - a WSDL description of the specified SOAP service. (SOAP)
* getOpenApi - an OpenAPI description of the specified REST service. (REST)

The metadata services have separate versions for SOAP and REST services. However, the "listCentralServices" service has only the SOAP version available. The SOAP versions of "listMethods" and "listAllowedMethods" contain information about the available SOAP services only and similarly, the REST versions contain information about the available REST services only. This means that in case information about all the available SOAP and REST services needs to be collected, both SOAP and REST versions of the "listMethods" metadata service must be invoked.


