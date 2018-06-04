# A test framework based on 3 layer structure
## Introduction
Most tests are combination of 3 type objects exists in 3 layers, the PO, SO, VO. After defining the PO, SO, VO , your test can be built like building blocks;
* PO, pojo object in data layer, define the biz object of your test
* SO, service object in the service layer, define the service of your test
* VO, verify object int he verify layer, define the verification of your test

