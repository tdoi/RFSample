# Robot Framework Sample Application

This project is sample for using robotframework with Selenium2Library.

## Preparation

Install Selenium2Library
```
pip install robotframework-selenium2library
```
Please see [robotframework/Selenium2Library](https://github.com/robotframework/Selenium2Library) for more details.

Older library might not work for new firefox.
At that time please run the following command:
```
pip install --upgrade robotframework-selenium2library
```


## Run Example

Start Jetty.
```
mvn jetty:run
```

Run Test

```
pybot ./src/test/resources/scenarios/
```

Stop Jetty
```
mvn jetty:stop
```
