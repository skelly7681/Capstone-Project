
<template>
    <div class="card">
        <img class="thumbnail" v-if="restaurant.thumbnailimg" v-bind:src="restaurant.thumbnailimg" />
        <button class="mark_invite" v-on:click.prevent="setInvite(true)" v-if=" !restaurant.invite">PLUS SIGN WILL GO HERE</button>
        <h3 class="restaurant-name">{{restaurant.name}}</h3>
        <h1 class="restaurant-type">{{restaurant.type}}</h1>
        <h1 class="restaurant-star-rating">*****</h1>
    </div>
</template>

<script>
export default {
    name: 'restaurant-card',
    props: {
        restaurant: Object
    },
    methods: {}

}
</script>

<style>

</style>