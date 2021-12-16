<template>
  <div>
      <h2 id="searchTitle" > FINALIST </h2>
      <display-finalist/>
  </div>
</template>

<script>
import DisplayFinalist from '../components/DisplayFinalist.vue'
export default {
    components: {
        DisplayFinalist
    }

}
</script>

<style>

#searchTitle {
    order: 1;
    padding: 10px;
    flex-basis: 67%;
    color: white;
    background-image: linear-gradient(to bottom right, rgb(114, 227, 241), rgb(235, 124, 235));
    font-weight: 600;
    font-style: italic;
}

</style>
