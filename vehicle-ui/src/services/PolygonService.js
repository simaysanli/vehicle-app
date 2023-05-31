import axios from 'axios';

const VEHICLE_API_BASE_URL = 'http://localhost:8081/v1/polygons';

class PolygonService{

    isCacheExpired(cacheTime) {
        const currentTime = new Date().getTime();
        return (currentTime - cacheTime) > (5 * 60 * 1000); // 5 minutes in milliseconds
    }

    getPolygons(){
        return axios.get(VEHICLE_API_BASE_URL);
    }


}

export default new PolygonService();
