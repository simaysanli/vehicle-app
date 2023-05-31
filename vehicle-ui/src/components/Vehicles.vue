<template>
  <div class = "container">

    <h1 class = "text-center"> Vehicles</h1>

    <table class = "table table-striped">
      <thead>
      <tr>
        <th>Location Id</th>
        <th>Vehicle Id</th>
        <th>Plate No</th>
        <th>Vehicle Model</th>
        <th>Fuel</th>
        <th>VIN</th>
      </tr>

      </thead>
      <tbody>
      <tr v-for="vehicle in vehicles" v-bind:key="vehicle.id">
        <td> {{vehicle.locationId}}</td>
        <td> {{vehicle.id }}</td>
        <td> {{vehicle.plateNumber}}</td>
        <td> {{vehicle.model}}</td>
        <td> {{vehicle.fuel}}</td>
        <td> {{vehicle.vin}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import VehicleService from "@/services/VehicleService";
export default {
  name: 'VehicleList',
  data(){
    return {
      vehicles: []
    }
  },
  methods: {
    getVehicles(){
      const cachedData = localStorage.getItem('vehicles');
      const cacheExpiry = localStorage.getItem('vehicles_expiry');
      const currentTime = new Date().getTime();

      if (cachedData && currentTime < cacheExpiry) {
        this.vehicles = JSON.parse(cachedData);
      } else {
        VehicleService.getVehicles().then((response) => {
          this.vehicles = response.data;
          localStorage.setItem('vehicles', JSON.stringify(this.vehicles));
          localStorage.setItem('vehicles_expiry', currentTime + 300000); // 5 minutes in milliseconds
        });
      }
    }
  },
  created() {
    this.getVehicles();
  }
}
</script>

<style scoped>

</style>