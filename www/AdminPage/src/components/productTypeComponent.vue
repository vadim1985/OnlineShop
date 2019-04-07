<template>
	<div id="mainProductTypeBlock" class="mainBlock">
		<div class="productBlock">
			<span v-if="errorText" class="error">{{ errorText }}</span>
			<p><b>Введите тип продукта</b></p>
			<input v-model="nameOfProductType" placeholder="Введите тип продукта">
			<button @click="postProductType">Сохранить</button>
		</div>
		<div class="productBlock">
			<div>
				<p><b>Выберите тип продукта</b></p>
				<select v-model="selectItem">
					<option v-for='index in listProductType' v-bind:value="index.id +  '/' +  index.name">{{index.name}}</option>
				</select>
			</div>
			<div>
				<p><b>Введите категорию продукта</b></p>
				<input v-model="nameOfProductCategory" placeholder="Введите категорию продукта">
				<button @click="postProductCategory">Сохранить</button>
			</div>
		</div>
	</div>
</template>
<script>
	export default {
	name: 'mainProductTypeBlock',
  	data () {
    	return {
    		nameOfProductType: null,
    		selectItem: null,
    		nameOfProductCategory: null,
    		errorText: null
    	}
  	},
  	beforeMount(){
  		this.$store.dispatch('loadListProductType');
  	},
  	computed:{
	    listProductType(){
	      return this.$store.getters.getListProductType
	    }
  	},
  	methods:{
  		postProductCategory(){
  			if (!this.selectItem || !this.nameOfProductCategory) {
  				this.errorText = "Заполните поля!";
  				return;
  			}
  			var arrayOfProductType = this.selectItem.split('/');
			var productCategory = {
					id: "",
					productType: {
						id: arrayOfProductType[0],
						name: arrayOfProductType[1]
					},
					name: this.nameOfProductCategory
			};
  			this.$store.dispatch('addProductCategory', productCategory);
  			this.errorText = null;
  			this.selectItem = null;
  			this.nameOfProductCategory = null;
  		},
  		postProductType(){
  			if (!this.nameOfProductType) {
  				this.errorText = "Заполните поля!";
  				return;
  			}
  			var productType = {
  				id: "",
  				name: this.nameOfProductType
  			}
  			this.$store.dispatch('addProductType', productType);
  			this.errorText = null;
  			this.nameOfProductType = null;
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