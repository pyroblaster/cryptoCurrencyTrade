package com.reptil.panda.cryptocurrencytrading.presenter


import com.reptil.panda.cryptocurrencytrading.interactor.ApiInteractor


class CoinPresenter(private val apiInteractor: ApiInteractor) : WeatherContract.Presenter {

    private var weatherView: WeatherContract.View? = null

    private val weatherCallback: Callback<WeatherResponse>
        get() = object : Callback<WeatherResponse>() {
            fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.body() != null) {
                    getWeather(response.body())
                }
            }

            fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherView!!.onFailure()
            }
        }

    fun setView(weatherView: WeatherContract.View) {
        this.weatherView = weatherView
    }


    fun getWeatherFromNet(city: String) {
        apiInteractor.getWeather(weatherCallback, city)
    }


    fun getWeather(weatherResponse: WeatherResponse) {
        getCurrentTemperatureValues(weatherResponse.getMain().getTemp_max())
        getPressureValues(weatherResponse.getMain().getPressure())
        getDescriptionValues(weatherResponse.getWeatherObject().getDescription())
        createWeatherIconValue(weatherResponse.getWeatherObject().getMain())
        getMinTemperatureValues(weatherResponse.getMain().getTemp_min())
        getMaxTemperatureValues(weatherResponse.getMain().getTemp_max())
        getWindValues(weatherResponse.getWind().getSpeed())
    }

    fun createWeatherIconValue(description: String?) {
        if (description != null)
            when (description) {
                Constants.SNOW_CASE -> {
                    getWeatherIcon(Constants.SNOW)
                }
                Constants.RAIN_CASE -> {
                    getWeatherIcon(Constants.RAIN)
                }
                Constants.CLEAR_CASE -> {
                    getWeatherIcon(Constants.SUN)
                }
                Constants.MIST_CASE -> {
                    getWeatherIcon(Constants.FOG)
                }
                Constants.FOG_CASE -> {
                    getWeatherIcon(Constants.FOG)
                }
                Constants.HAZE_CASE -> {
                    getWeatherIcon(Constants.FOG)
                }

                Constants.CLOUD_CASE -> {
                    getWeatherIcon(Constants.CLOUD)
                }

                Constants.THUNDERSTORM_CASE -> {
                    getWeatherIcon(Constants.CLOUD)
                }
            }
    }

    fun getCurrentTemperatureValues(temperatureValues: Double) {
        weatherView!!.setCurrentTemperatureValues(toCelsiusFromKelvin(temperatureValues))
    }

    fun getMinTemperatureValues(minTemperatureValues: Double) {
        weatherView!!.setMinTemperatureValues(toCelsiusFromKelvin(minTemperatureValues))
    }

    fun getMaxTemperatureValues(maxTemperatureValues: Double) {
        weatherView!!.setMaxTemperatureValues(toCelsiusFromKelvin(maxTemperatureValues))
    }

    fun getPressureValues(pressureValues: Double) {
        weatherView!!.setPressureValues(pressureValues)
    }

    fun getWindValues(windValues: Double) {
        weatherView!!.setWindValues(windValues)
    }

    fun getWeatherIcon(iconPath: String) {
        weatherView!!.setWeatherIcon(iconPath)
    }

    fun getDescriptionValues(descriptionValues: String) {
        weatherView!!.setDescriptionValues(descriptionValues)
    }

    private fun toCelsiusFromKelvin(temperature: Double): Double {
        return temperature - 273
    }
}