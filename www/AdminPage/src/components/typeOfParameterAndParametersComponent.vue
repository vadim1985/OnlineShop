<template>
	<div id="mainTypeOfParameterBlock" class="mainBlock">
		<div class="productBlock">
			<span v-if="errorText" class="error">{{ errorText }}</span>
			<p><b>Введите тип параметра</b></p>
			<input v-model.trim="nameTypeOfParameter" placeholder="Введите тип параметра">
			<button @click="addTypeOfParameter">Сохранить</button>
		</div>
		<div>
			<div class="productBlock">
				<p><b>Выберите параметр</b></p>
				<select v-model="selectedTypeOfParameter">
					<option v-for='index in listTypeOfParameter' v-bind:value="index.id +  '/' +  index.name">{{index.name}}</option>
				</select>
			</div>
			<div class="productBlock">
				<p><b>Введите параметры через "," без пробелов</b></p>
				<input v-model.trim="nameOfParameter" placeholder="Введите параметр">
				<button @click="addListParameterInType">Сохранить</button> 
			</div>
		</div>
	</div>
</template>
<script>
	export default {
		name: 'mainTypeOfParameterBlock',
	  	data () {
	    	return {
	    		selectedTypeOfParameter: null,
	    		nameOfParameter: null,
	    		errorText: null,
	    		nameTypeOfParameter: null
	    	}
	  	},
	  	beforeMount(){
	  		this.$store.dispatch('loadListTypeOfParameter');
	  	},
	  	computed:{
		    listTypeOfParameter(){
		      return this.$store.getters.getListTypeOfParameter
		    }
	  	},
	  	methods:{
	  		addListParameterInType(){
	  		if (!this.selectedTypeOfParameter || !this.nameOfParameter) {
  				this.errorText = "Заполните поля!";
  				return;
  			}
	  			var id = this.selectedTypeOfParameter.split('/');
				var tmpParameters = this.nameOfParameter.split(',');
				var parameters = tmpParameters.map(function(index) {
					console.log(index);
					return {
						id: "",
						name: index,
						typeOfParameter: {
							id: id[0],
							name: id[1]
						}
					};
				});
	  			this.$store.dispatch('loadListParameterInType', parameters);
	  			this.selectedTypeOfParameter = null;
	  			this.nameOfParameter = null;
	  			this.errorText = null;
	  		},
	  		addTypeOfParameter(){
	  		if (!this.nameTypeOfParameter) {
  				this.errorText = "Заполните поля!";
  				return;
  			}
	  			var typeOfParameter = {
	  				id: "",
	  				name: this.nameTypeOfParameter
	  			}
	  			this.$store.dispatch('loadTypeOfParameter', typeOfParameter);
	  			this.nameTypeOfParameter = null;
	  			this.errorText = null;
	  		}
	  	}
	}
</script>
<style scoped>
	.mainBlock {
		display: flex;
	  	flex-direction: row;
	  	margin-bottom: 2px;
	}
	.productBlock {
		margin-left: 2px;
		padding: 5px;
	}
	.error {
		color: red;
	}
</style>