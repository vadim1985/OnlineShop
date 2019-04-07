import Vue from 'vue'
import Vuex from 'vuex'
import Axios from 'axios'

Vue.use(Vuex)

	var state = {
		listProductType: null,
	};

	var getters = {
		getListProductType: state => {
			return state.listProductType;
		}
	};

	var mutations = {
		setListProductType: (state, payload) => {
			state.listProductType = payload;
		},
		pushProductType: (state, payload) => {
			state.listProductType.push(payload);
		},
	};

	var actions = {
		loadListProductType: context => {
			Axios.get("http://localhost:8081/productType")
			.then(response => {
      			let data = response.data;
     		 	context.commit('setListProductType', data)
    		});
		},
		addProductCategory: (context, payload) =>{
			Axios({
					method: 'post',
					url: 'http://localhost:8081/productCategory',
					data: payload
				});
		},
		addProductType: (context, payload) =>{
			Axios({
					method: 'post',
					url: 'http://localhost:8081/productType',
					data: payload
				}).then(response =>{
					context.commit('pushProductType', response.data);
					state.listProductType.forEach(i => console.log(i));
				});
		}
	};

	export default {
		state,
		getters,
		mutations,
		actions
	}

