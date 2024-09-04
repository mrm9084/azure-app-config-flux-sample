# azure-app-config-flux-sample
 
## Setup

1. Create a Azure App Configuration Store
1. Create configuration `/application/config.message` with some value.
1. Create configuration `sentinel` with some value.
1. Setup Environment Variable `CONFIGSTORE_CONNECTION_STRING`

## Run Application

`mvn spring-boot:run`

`localhost:8080` will display the the value of `config.message`.

### Refresh

1. Update the value of `/application/config.message`
1. Update the value of `sentinel`
1. Refresh the page of `localhost:8080`, this will trigger the refresh.

Note: In this sample the page will only trigger a refresh every 15s at most. You might have to wait a few seconds for it to be trigger-able.
Note2: The first refresh will only trigger the update. A second page refresh will be needed after the update to access the new configurations.
Note3: Currently this sample fails when a refresh is triggered.
