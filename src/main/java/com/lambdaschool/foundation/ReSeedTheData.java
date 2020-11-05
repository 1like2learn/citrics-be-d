package com.lambdaschool.foundation;

import com.lambdaschool.foundation.dtos.CityInfo;
import com.lambdaschool.foundation.dtos.DataSeeder;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configurers.UrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Transactional
@Component
public class ReSeedTheData implements CommandLineRunner {

    public class DataSeederListClass {
        private List<DataSeeder> cities = new ArrayList<>();

        public DataSeederListClass() {
        }

        public List<DataSeeder> getCities() {
            return cities;
        }

        public void setCities(List<DataSeeder> cities) {
            this.cities = cities;
        }
    }

    @Override
    public void run(String... args) throws Exception {
        URL baseUrl = new URL("https://labs27-c-citrics-api.herokuapp.com/cities/allid");
        var connection = (HttpURLConnection) baseUrl.openConnection();
        connection.setRequestMethod(HttpMethod.GET.name());

        var stream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        var cities = mapper.readValue(stream, CityInfo[].class);
        var count = 1;
        for(var city : cities)
        {
            URL getUrl = new URL(String.format("https://labs27-c-citrics-api.herokuapp.com/cities/city/%d", city.getCityid()));
            var getUrlConnection = (HttpURLConnection) getUrl.openConnection();
            getUrlConnection.setRequestMethod(HttpMethod.GET.name());
            var getStream = getUrlConnection.getInputStream();

            ObjectMapper getMapper = new ObjectMapper();
            var seeder = getMapper.readValue(getStream, DataSeeder.class);
            System.out.println(String.format("Finsihed %d", count));
            count++;
        }
    }
}
