package Proxy;

import java.util.HashMap;
import java.util.Map;

public class NetworkServiceProxy implements NetworkService {
    
    private RealNetworkService realNetworkService;
    private Map<String, String> cache;

    public NetworkServiceProxy() {
        cache = new HashMap<>();
    }

    @Override
    public String fetchData(String input) {
        
        if (cache.containsKey(input)) {
            System.out.println("Fetching data from cache");
            return cache.get(input);
        }

        if (realNetworkService == null) {
            realNetworkService = new RealNetworkService();
        }
        
        String data = realNetworkService.fetchData(input);
        cache.put(input, data);
        return data;
    }
}