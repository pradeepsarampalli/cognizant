package com.example.mockito;

/**
 * Represents a third-party / external API dependency.
 * In the real app this would make an HTTP call, hit a database, etc.
 */
public interface ExternalApi {

    String getData();

    String getDataById(String id);

    void performAction(String action);
}
