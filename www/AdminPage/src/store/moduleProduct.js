import Vue from 'vue'
import Vuex from 'vuex'
import Axios from 'axios'

Vue.use(Vuex)

	var state = {
		listProductCategory: null,
		listParameter: null,
		selectedParameter: []
	};

	var getters = {
		getListProductCategory: state => {
			return state.listProductCategory;
		},
		getListParameter: state => {
			return state.listParameter;
		},
		getSelectedParameter: state => {
			return state.selectedParameter;
		}
	};

	var mutations = {
		setListProductCategory: (state, payload) => {
			state.listProductCategory = payload;
		},
		setListParameter: (state, payload) => {
			state.listParameter = payload;
		},
		addParamrter: (state, payload) => {
			state.selectedParameter.push(payload);
		},
		clearSelectedParameter: (state, payload) => {
			state.selectedParameter = payload;
		}
	};

	var actions = {
		loadListProductCategory: (context, payload) =>{
			Axios.get("http://localhost:8081/productCategory/" + payload)
			.then(response =>{
				context.commit('setListProductCategory', response.data);
			});
		},
		loadListParameter: (context, payload) => {
			Axios.get("http://localhost:8081/parameter/" + payload)
			.then(response =>{
				context.commit('setListParameter', response.data);
			});
		},
		addProduct: (context, payload) => {
			Axios({
				method: 'post',
				url: 'http://localhost:8081/product',
				data: payload
			});
			context.commit('clearSelectedParameter', []);
		}
	};

	export default {
		state,
		getters,
		mutations,
		actions
	}

