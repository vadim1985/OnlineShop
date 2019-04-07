<template>
  <div id="app">
    <product-type-component></product-type-component>
    <hr>
    <type-of-parameter-component></type-of-parameter-component>
    <hr>
    <product-component></product-component>
  </div>
</template>

<script>
import productTypeComponent from './components/productTypeComponent.vue';
import typeOfParameterAndParametersComponent from './components/typeOfParameterAndParametersComponent.vue';
import productComponent from './components/productComponent.vue';
export default {
  components: {
    'product-type-component': productTypeComponent,
    'type-of-parameter-component': typeOfParameterAndParametersComponent,
    'product-component': productComponent
  }
}
</script>

<style>
  .myTable {
    border: 1px solid black;
  }
</style>