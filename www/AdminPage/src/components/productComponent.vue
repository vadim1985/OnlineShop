<template>
	<div id="mainProductBlock" class="mainBlock">
		<span v-if="errorText" class="error">{{ errorText }}</span>
		<p><b>Введите наименование продукта</b></p>
			<input v-model="nameOfProduct" placeholder="Введите наименование продукта">
		<p><b>Введите описание продукта</b></p>

			<textarea v-model="descriptionOfProduct" placeholder="Введите описание продукта"></textarea>
		<p><b>Выберите тип продукта</b></p>

		<select v-model="selectProductType" @change="addListProductCategory">
			<option v-for='indexProductType in listProductType' 
					:value="indexProductType.id +  '/' +  indexProductType.name">{{indexProductType.name}}</option>
		</select>
		<select v-model="selectProductCategory">
			<option v-for='indexProductCategory in listProductCategory' 
					:value="indexProductCategory.id +  '/' +  indexProductCategory.name">{{indexProductCategory.name}}</option>
		</select>
		<div>
			<button @click="addLayerProductProperties">Добавить запись</button>
			<table v-if="listSelectedParameter" class="mainTable">
				<tr>
					<th>Тип параметра</th><th>Параметр</th><th>Удалить</th>
				</tr>
				<tr v-for="(indexOfSelectedParameter, i) in listSelectedParameter">
					<td>
						<select v-model="indexOfSelectedParameter.typeOfParameter">
							<option 
							:value="indexTypeOfParameter.id +  '/' +  indexTypeOfParameter.name" 
							v-for="indexTypeOfParameter in listTypeOfParameter">{{indexTypeOfParameter.name}}</option>
						</select>
					</td>
					<td>
						<div v-if="indexOfSelectedParameter.typeOfParameter">
							<select-properties :idtype="addListParameter(i)" 
							v-model="indexOfSelectedParameter.nameOfParameter"></select-properties>
						</div>
					</td>
					<td><button @click="delProperties(i)">Удалить</button></td>
				</tr>
			</table>
			<button @click="showParameter">Добавить продукт</button>
		</div>
	</div>
</template>

<script>
	import selectProperties from './selectProperties.vue';
	export default {
		name: 'mainProductTypeBlock',
	  	data () {
	    	return {
	    		nameOfProduct: null,
	    		descriptionOfProduct: null,
	    		selectProductType: null,
	    		selectProductCategory: null,
	    		errorText: null
	    	}
	  	},
	  	beforeMount(){

	  	},
	  	components: {
	  		'select-properties': selectProperties
	  	},
	  	computed:{
		  	listProductType(){
		    	return this.$store.getters.getListProductType
		    },
		    listProductCategory(){
		    	return this.$store.getters.getListProductCategory
		    },
		    listTypeOfParameter(){
		      	return this.$store.getters.getListTypeOfParameter
		    },
		    listSelectedParameter(){
		    	return this.$store.getters.getSelectedParameter
		    },
		    listParameters(){
		    	return this.$store.getters.getListParameter
		    }
	  	},
	  	methods:{
	  		addListProductCategory(){
	  			var arrayOfProductType = this.selectProductType.split('/');
	  			this.$store.dispatch('loadListProductCategory', arrayOfProductType[0])
	  		},
	  		addListParameter(i){
	  			var arrayOfParameters = this.listSelectedParameter[i].typeOfParameter.split('/');
	  			return arrayOfParameters[0];
	  		},
	  		addLayerProductProperties(){
	  			this.$store.commit('addParamrter', {
						nameOfParameter: "",
						typeOfParameter: ""
	  			})
	  		},
	  		showParameter(){
	  			if (!this.nameOfProduct || 
	  				!this.descriptionOfProduct || 
	  				!this.selectProductCategory ||
	  				!this.selectProductType) { 
		  				this.errorText = "Заполните все поля!";
		  				return;
	  			}
	  			var arrayOfProductCategory = this.selectProductCategory.split('/');
	  			var arraySelectProductType = this.selectProductType.split('/');
	  			var arrayOfParameter = this.$store.getters.getSelectedParameter.map(function(index) {
	  				if (!index.nameOfParameter || !index.typeOfParameter) {
		  				return;
	  				}
	  				var nameOfParameter = index.nameOfParameter.split('/');
	  				var typeOfParameter = index.typeOfParameter.split('/');
	  				return {
	  					id: nameOfParameter[0],
	  					name: nameOfParameter[1],
	  					typeOfParameter: {
	  						id: typeOfParameter[0],
	  						name: typeOfParameter[1]
	  					}
	  				};
	  			})
	  			var product = {
	  				id:"",
	  				name: this.nameOfProduct,
	  				description: this.descriptionOfProduct,
	  				productCategory:{
	  					id: arrayOfProductCategory[0],
	  					name: arrayOfProductCategory[1],
	  					productType:{
	  						id: arraySelectProductType[0],
	  						name: arraySelectProductType[1]
	  					}
	  				},
	  				parameters: arrayOfParameter
	  			};
	  			console.log(product);
	  			this.$store.dispatch('addProduct', product);
	  			this.selectProductType = null;
	    		this.selectProductCategory = null;
	    		this.nameOfProduct = null;
	    		this.descriptionOfProduct = null;
	    		this.errorText = null;
	  		},
	  		delProperties(i){
	  			this.listSelectedParameter.splice(i, 1);
	  		}
	  	}
  	}
</script>

<style>
	.mainTable {
		border: 1px solid black;
	}
	.error {
		color: red;
	}
</style>