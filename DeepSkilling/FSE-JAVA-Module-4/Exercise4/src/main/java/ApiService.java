public class ApiService {
    RestClient restClient;

    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }
    public  String fetchData(){
        return restClient.getResponse();
    }
}
