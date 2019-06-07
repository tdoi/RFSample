*** Settings ***
Library           SeleniumLibrary

*** Variables ***
${BROWSER}        chrome

*** Test Cases ***
Add Operation Works Well
    [Template]    Add Operation Workflow
    1    1    2
    100    200    300
    XYZ    150    N/A

*** Keywords ***
Add Operation Workflow
    [Arguments]    ${arg1}    ${arg2}    ${expected}
    Open Application Page
    ${calc_value}=    Calculate In Application Page    ${arg1}    ${arg2}
    Should Be Equal    ${calc_value}    ${expected}
    Close Application Page

Open Application Page
    Open Browser    http://localhost:8080/calculate    ${BROWSER}

Calculate In Application Page
    [Arguments]    ${arg1}    ${arg2}
    Input Text    arg1    ${arg1}
    Input Text    arg2    ${arg2}
    Submit Form
    BuiltIn.Sleep	1
    ${result}=    Get Value    result
    [Return]    ${result}

Close Application Page
    Close Browser
