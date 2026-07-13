package com.example.mockito;

/**
 * Service under test. Depends on ExternalApi, which we will mock in tests.
 */
public class MyService {

    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String fetchDataById(String id) {
        return externalApi.getDataById(id);
    }

    public void triggerAction(String action) {
        externalApi.performAction(action);
    }
}
