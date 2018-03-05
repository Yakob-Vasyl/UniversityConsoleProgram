package Service;

import Entity.Lector;
import Dao.LectorDao;

import java.util.stream.Collectors;

public class LectorService {
    private LectorDao dao = new LectorDao();

    public String getLectorsBySearhString(String searchString) {
       return dao.searchLectorsByString(searchString).stream().map(Lector::getName).collect(Collectors.joining(", "));
    }

}
