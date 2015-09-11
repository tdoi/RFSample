# Robot Framework Sample Application

This project is sample for using robotframework with Selenium2Library.

## Preparation

Install Selenium2Library
```
pip install robotframework-selenium2library
```
Please see [robotframework/Selenium2Library](https://github.com/robotframework/Selenium2Library) for more details.

## Run Example

Start Jetty.
```
mvn jetty
```

Run Test

```
pybot ./src/test/resources/scenarios/
```

Stop Jetty
```
mvn jetty:stop
```
