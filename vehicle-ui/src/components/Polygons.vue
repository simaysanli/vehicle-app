<template>
  <div class = "container">

    <h1 class = "text-center"> Polygons</h1>

    <table class = "table table-striped">
      <thead>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Type</th>
        <th>City Id</th>
      </tr>

      </thead>
      <tbody>
      <tr v-for="polygon in polygons" v-bind:key="polygon.id">
        <td> {{polygon._id}}</td>
        <td> {{polygon.name}}</td>
        <td> {{polygon.type }}</td>
        <td> {{polygon.cityId}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

import PolygonService from "@/services/PolygonService";
export default {
  name: "PolygonList",
  data(){
    return {
      polygons: []
    }
  },
  methods: {
    getPolygons() {
      const cacheKey = "polygons";
      const cacheDuration = 5 * 60 * 1000; // 5 minutes in milliseconds
      const cachedData = JSON.parse(localStorage.getItem(cacheKey));
      const now = new Date().getTime();

      if (cachedData && now - cachedData.timestamp < cacheDuration) {
        this.polygons = cachedData.data;
      } else {
        PolygonService.getPolygons().then((response) => {
          this.polygons = response.data;
          localStorage.setItem(
              cacheKey,
              JSON.stringify({
                data: this.polygons,
                timestamp: now
              })
          );
        });
      }
    },
  },
  created() {
    this.getPolygons();
  }
}
</script>

<style scoped>

</style>