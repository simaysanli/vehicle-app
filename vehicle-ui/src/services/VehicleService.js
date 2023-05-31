import axios from 'axios';

const VEHICLE_API_BASE_URL = 'http://localhost:8081/v1/vehicles';

class VehicleService{

    getVehicles(){
        return axios.get(VEHICLE_API_BASE_URL);
    }
}

export default new VehicleService();