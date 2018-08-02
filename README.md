# TSTest - PSV Pattern

## Introduction
TSTest-PSV Pattern(Test Service-Test-PSVPattern) is a test framework based on PO(Pojo object),SO(Service object),VO(Verify object). Most tests are combination of these 3 type objects in 3 layers, after defining the PO,SO,VO of the test field, the test case can be built like lego

- PO, pojo object in data layer, define the biz object of your test
- SO, service object in the service layer, define the service of your test
- VO, verify object in the verify layer, define the verification of your test

A example case like below,
```
  ReqPO reqPO = new ReqPO();
  ResPO resPO = SO.sendRequest(reqPO);
  VO.verify(resPO)
```
## Author
Jun Qin
## Bug and issues
If you find any bug or issues, be free to send mail to zeroneqin@163.com
## License
MIT©️Jun Qin
