# OpenWeather

The app get list of weathers from [OpenWeatherApi](https://openweathermap.org/) with URL: 
https://api.openweathermap.org/data/2.5/forecast/q=saigon&cnt=7&appid=app_id

### Functionality

The app has 2 main screens:

#### SearchFragment

This fragment displays a list of weathers searching.

#### DetailFragment

This fragment displays detail of weather.

## Known Issues

Error Handling: not show clear errors, should improve more.

DetailViewMode: DetailViewModel is scoped highly in Activity , must be scoped in the Fragment with using @ViewModelInject and @Assisted

Not have clear structure between features if having many features

Have issues with flow, livedata when mock for testing.

## Improvement (in future)

Restructure to multimodule app to build app easily to scale

Should improve unit test more with Flow, LiveData



