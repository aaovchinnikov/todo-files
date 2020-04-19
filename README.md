We have to strategies for reading objects from datasource
1. new object knows its datasource, reads it and maintains itself ("Read source and maintain").
2. new datasource access implemented in separate object, that builds domain object and returns it ("Read source and return" or "Separated source").
Supposed rule:
Use separated source strategy in cases when it's difficult to delegate modifications of the domain object to underling datasource. 