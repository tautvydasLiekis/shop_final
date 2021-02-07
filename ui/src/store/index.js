import {configureStore} from "@reduxjs/toolkit";
import {logger} from "redux-logger";
import user from './slices/userSlice'

export const createStore = (initialState) => {

	const store = configureStore({
		reducer: {
			user
		},
		middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(logger)
	})
	return store
}

export default createStore()
