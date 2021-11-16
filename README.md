Due to running out of time this homework misses deployment into a docker container and better exception handling

The application can be started by using : mvn spring-boot:run

To test the application you can either access the following urls in your browser or do them as curl cmd calls:
curl -k -v  http://localhost:8080/evaluation?url=/csvFiles/speeches1.csv
curl -k -v  http://localhost:8080/evaluation?url=/csvFiles/speeches2.csv
curl -k -v  http://localhost:8080/evaluation?url=/csvFiles/speeches1.csv&url=/csvFiles/speeches2.csv

Additionally you can add new csf files and append them to your calls as you wish
