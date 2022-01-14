run: compile
	java Frontend

compile: Frontend.class TestFrontend.class  Backend.class DataWrangler.class GraphADT.class CS400Graph.class Connection.class Intersection.class Path.class BackendTests.class TestDataWrangler.class 

Frontend.class: Frontend.java
	javac Frontend.java

Backend.class: Backend.java
	javac Backend.java

DataWrangler.class: DataWrangler.java
	javac DataWrangler.java

CS400Graph.class: CS400Graph.java
	javac CS400Graph.java

GraphADT.class: GraphADT.java
	javac GraphADT.java

Connection.class: Connection.java
	javac Connection.java

Intersection.class: Intersection.java
	javac Intersection.java

Path.class: Path.java
	javac Path.java

BackendTests.class: BackendTests.java
	javac -cp .:junit5.jar BackendTests.java

TestDataWrangler.class: TestDataWrangler.java
	javac -cp .:junit5.jar TestDataWrangler.java

TestFrontend.class: TestFrontend.java
	javac -cp .:junit5.jar TestFrontend.java

test: testBackend testData testFrontend

testFrontend: compile 
	java -jar junit5.jar -cp . --scan-classpath -n TestFrontend 
	
testBackend: compile 
	java -jar junit5.jar -cp . --scan-classpath -n BackendTests 

testData: compile 
	java -jar junit5.jar -cp . --scan-classpath -n TestDataWrangler


clean:
	$(RM) *.class
