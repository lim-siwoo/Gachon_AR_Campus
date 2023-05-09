# Gachon AR Navigation

# Index

- Introduction
- Features
- How to use
- Method explain
- Conclusion

# Gachon AR Navigation

이 문서는 Gachon AR Navigation에 대한 내용을 다룹니다.

## Introduction

Gachon AR Navigation is a mobile app designed to help users navigate the Gachon University campus. By using augmented reality technology, the app displays real-time information about your surroundings, including building names, directions, and other points of interest. With Gachon AR Navigation, you can easily find your way around campus and explore all that Gachon University has to offer.

## Features

- Augmented reality view
- Real-time information about surroundings
- Building names and directions
- Firebase user authentication & bulletin board
- Points of interest
- Easy campus navigation

## How to use

1. Download and install the Gachon AR Navigation app from the App Store or Google Play Store.
2. Open the app and allow it to access your camera and location.
3. Point your camera at your surroundings to see building names, directions, and other points of interest.
4. Use the map to view your location and navigate around campus.
5. Enjoy exploring Gachon University with ease and convenience!

## Method explain

Gachon AR Navigation uses Mapbox SDK to create its augmented reality view. The SDK provides real-time location data and map rendering capabilities, allowing the app to display accurate and up-to-date information about your surroundings. With Mapbox SDK, Gachon AR Navigation is able to provide a seamless and intuitive navigation experience for users.


### How to Install Mapbox SDK Navigation

1. Go to the Mapbox website and create an account.
2. Once you have created an account, log in and go to the "Account" section.
3. Under the "Access Tokens" tab, create a new access token.
4. Copy the access token and paste it into your project's code.
5. Install the Mapbox SDK Navigation library using whatever package manager you are using for your project (e.g. npm, pip).
6. Import the Mapbox SDK Navigation library into your project's code.
7. You are now ready to use Mapbox SDK Navigation in your project!

![sdk-install.png](Gachon%20AR%20Navigation%2047bfd5a59d6b4f398a923c36195d8787/sdk-install.png)

### Method explain - getRoute

One of the key features of Gachon AR Navigation is its ability to provide directions to specific locations on the Gachon University campus. To achieve this, the app uses the Mapbox Directions API to generate routes between the user's current location and their desired destination. The getRoute function is a custom implementation of the Mapbox Directions API that is used to request and parse route data from the API. The function takes in the user's current location and their desired destination as input and returns a route object that includes step-by-step directions and estimated travel time. With this feature, users can easily navigate to any location on campus with confidence and ease.

```java
private void getRoute_navi_walking (Point origin, Point destinaton) {
        // TODO : https://docs.mapbox.com/android/navigation/overview/map-matching/
        NavigationRoute.builder(this).accessToken(Mapbox.getAccessToken())
                .profile(DirectionsCriteria.PROFILE_WALKING)//도보 길찾기
                .origin(origin)//출발지
                .destination(destinaton).//도착지
                build().
                getRoute(new Callback<DirectionsResponse>() {
                    @Override
                    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                        if (response.body() == null) {
                            return;
                        } else if (response.body().routes().size() ==0) {
                            return;
                        }
                        currentRoute = response.body().routes().get(0);
                        if (navigationMapRoute != null) {
                            navigationMapRoute.removeRoute();
                        } else {
                            navigationMapRoute = new NavigationMapRoute(null, mapView, mapboxMap, com.mapbox.services.android.navigation.ui.v5.R.style.NavigationMapRoute);
                        }
                        navigationMapRoute.addRoute(currentRoute);
                    }
                    @Override
                    public void onFailure(Call<DirectionsResponse> call, Throwable t) {
                    }
                });
    }
```

### Method explain - setDestination

![setDesti_img.png](Gachon%20AR%20Navigation%2047bfd5a59d6b4f398a923c36195d8787/setDesti_img.png)

Another key feature of Gachon AR Navigation is the ability to set a destination and receive turn-by-turn directions to that destination. When the user selects a destination on the app's map, the setDestination function is called. This function calculates the shortest route from the user's current location to the selected destination using the Mapbox Directions API. Once the route is calculated, the app displays turn-by-turn directions to the user, including distance and estimated travel time for each step of the route. With this feature, users can easily navigate to any location on campus with confidence and ease.

```java
@Override
            public void onClick(final View v) {
                final PopupMenu popupMenu = new PopupMenu(getApplicationContext(), v);
                getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        //제 1공학관
                        if (item.getItemId() == R.id.action_menu1){
                            destination_zoom(37.45158,127.12795);
                        }
                        //제 2공학관
                        else if (item.getItemId() == R.id.action_menu2){
                            destination_zoom(37.45047,127.12842);
                        }
                        //가천관
                        else if (item.getItemId() == R.id.action_menu3){
                            destination_zoom(37.45048,127.12952);
                        }
                        //AI 공학관
                        else if (item.getItemId() == R.id.action_menu4){
                            destination_zoom(37.45532,127.13438);
                        }
                        //가천대역
                        else if (item.getItemId() == R.id.action_menu5){
                            destination_zoom(37.44939,127.12768);
                        }
                        //글로벌센터
                        else if (item.getItemId() == R.id.action_menu6){
                            destination_zoom(37.45191,127.12708);
                        }
                        //IT융합대학
                        else if (item.getItemId() == R.id.action_menu7){
                            destination_zoom(37.45099,127.12714);
                        }
                        //산학협력관
                        else if (item.getItemId() == R.id.action_menu8){
                            destination_zoom(37.44952,127.12945);
                        }
                        //한의과대학
                        else if (item.getItemId() == R.id.action_menu9){
                            destination_zoom(37.45004,127.12847);
                        }
                        //바이오나노연구원
                        else if (item.getItemId() == R.id.action_menu10){
                            destination_zoom(37.44988,127.12804);
                        }
                        //법과대학
                        else if (item.getItemId() == R.id.action_menu11){
                            destination_zoom(37.44925,127.12745);
                        }
                        //비전타워
                        else if (item.getItemId() == R.id.action_menu12){
                            destination_zoom(37.44967,127.12714);
                        }
                        //정문
                        else if (item.getItemId() == R.id.action_menu13){
                            destination_zoom(37.45050,127.12684);
                        }
                        //전자정보도서관
                        else if (item.getItemId() == R.id.action_menu14){
                            destination_zoom(37.45069,127.12852);
                        }
                        //학군단
                        else if (item.getItemId() == R.id.action_menu15){
                            destination_zoom(37.45152,127.12887);
                        }
                        //예술체육대학2
                        else if (item.getItemId() == R.id.action_menu16){
                            destination_zoom(37.45169,127.12963);
                        }
                        //예술체육대학1
                        else if (item.getItemId() == R.id.action_menu17){
                            destination_zoom(37.45214,127.12872);
                        }

                        //대학원
                        else if (item.getItemId() == R.id.action_menu18){
                            destination_zoom(37.45270,127.13006);
                        }
                        //교육대학원
                        else if (item.getItemId() == R.id.action_menu19){
                            destination_zoom(37.45187,127.13165);
                        }

                        //중앙도서관
                        else if (item.getItemId() == R.id.action_menu20){
                            destination_zoom(37.45228,127.13305);
                        }

                        //학생회관
                        else if (item.getItemId() == R.id.action_menu21){
                            destination_zoom(37.45318,127.13437);
                        }

                        //학생생활관(기숙사)
                        else if (item.getItemId() == R.id.action_menu22){
                            destination_zoom(37.45590,127.13464);
                        }
```

```xml
<!--목적지 설정 문자열열-->
    <string name="destination_setting">목적지 설정</string>
    <string name="College_of_Engineering_Building1">제 1공학관</string>
    <string name="College_of_Engineering_Building2">제 2공학관</string>
    <string name="AI_Hall">AI 공학관</string>
    <string name="Gachon_Univ_Station">가천대역</string>
    <string name="Global_Center">글로벌센터</string>
    <string name="BumJeong_Hall">IT융합대학</string>
    <string name="Humanities_Hall">산학협력관</string>
    <string name="Business_and_Economics_Hall">한의과대학</string>
    <string name="Education_Hall">바이오나노연구원</string>
    <string name="Hyedang_Hall">법과대학</string>
    <string name="Toegye_Memorial_Central_Library">비전타워</string>
    <string name="Graduate_School">정문</string>
    <string name="International_Hall">전자정보도서관</string>
    <string name="Laboratories">학군단</string>
```

```xml
<!--목적지 설정 버튼 팝업 메뉴 설정-->
    <item
        android:id="@+id/action_menu1"
        android:title="@string/College_of_Engineering_Building1"/>
    <item
        android:id="@+id/action_menu2"
        android:title="@string/College_of_Engineering_Building2" />
    <item
        android:id="@+id/action_menu3"
        android:title="@string/AI_Hall" />

    <item
        android:id="@+id/action_menu4"
        android:title="@string/Gachon_Univ_Station" />

    <item
        android:id="@+id/action_menu5"
        android:title="@string/Global_Center" />
```

### Method explain - get User Position

To provide real-time information about the user's surroundings, Gachon AR Navigation needs to constantly track the user's position. The getUserPosition function is responsible for retrieving the user's current location using the device's GPS or other location services. Once the user's location is obtained, the app uses Mapbox SDK to render a map of the user's surroundings and display relevant information, such as building names and directions. With this feature, users can easily navigate the Gachon University campus with confidence and ease.

1. Method to show location of the user

```java
private void enableLocationComponent(@NonNull Style loadedMapStyle) {
        Log.e(TAG,"enableLocationComponent 실행");
        // Check if permissions are enabled and if not request
        if (PermissionsManager.areLocationPermissionsGranted(this)) {
            // Activate the MapboxMap LocationComponent to show user location
            // Adding in LocationComponentOptions is also an optional parameter
            locationComponent = mapboxMap.getLocationComponent();
            locationComponent.activateLocationComponent(this, loadedMapStyle);
            locationComponent.setLocationComponentEnabled(true);
            // Set the component's camera mode
            locationComponent.setCameraMode(CameraMode.TRACKING);
            initLocationEngine();
        } else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(this);
        }
    }
private void initLocationEngine() {
        Log.e(TAG,"initLocationEngine 실행");
        locationEngine = LocationEngineProvider.getBestLocationEngine(this);
        LocationEngineRequest request = new LocationEngineRequest.Builder(DEFAULT_INTERVAL_IN_MILLISECONDS)
                .setPriority(LocationEngineRequest.PRIORITY_HIGH_ACCURACY)
                .setMaxWaitTime(DEFAULT_MAX_WAIT_TIME).build();
        locationEngine.requestLocationUpdates(request, callback, getMainLooper());
        locationEngine.getLastLocation(callback);
    }
```

1. Get Text from String.xml

```java
//안드로이드 기기 위치 추적
    //현재 위치 얻어오는 콜백
    class MainActivityLocationCallback implements LocationEngineCallback<LocationEngineResult> {
        private final WeakReference<MainActivity> activityWeakReference;
        MainActivityLocationCallback(MainActivity activity) {
            this.activityWeakReference = new WeakReference<>(activity);
        }
				/**
         * The LocationEngineCallback interface's method which fires when the device's location has changed.
         * @param result the LocationEngineResult object which has the last known location within it.
         */

        @Override
        public void onSuccess(LocationEngineResult result) {
            Log.e(TAG,"MainActivityLocationCallback onSuccess 실행");
            MainActivity activity = activityWeakReference.get();
            if (activity != null) {
                Location location = result.getLastLocation();
                if (location == null) {
                    return;
                }
                // Create a Toast which displays the new location's coordinates
                La = result.getLastLocation().getLatitude();
                Lo = result.getLastLocation().getLongitude();

                // Pass the new location to the Maps SDK's LocationComponent
                if (activity.mapboxMap != null && result.getLastLocation() != null) {
                    activity.mapboxMap.getLocationComponent().forceLocationUpdate(result.getLastLocation());
                }
            }
        }
```


## AR Explanation

This section will explain about AR Explanation function

### Unity AR + GPS Location Package

Package to support location based AR

details : [Unity AR+GPS Location | Unity AR+GPS Location Docs (v3.6.0)](https://docs.unity-ar-gps-location.com/#main-features)

### AR Foundation

Unity package that support to create multi-platform augmented reality apps with Unity.

It support to choose which AR features to enable by adding the corresponding manager components to unity scene.

details : [https://docs.unity3d.com/Packages/com.unity.xr.arfoundation@5.0/manual/index.html](https://docs.unity3d.com/Packages/com.unity.xr.arfoundation@5.0/manual/index.html)

### AR Core

AR Core is Google’s augmented reality SDK offering cross-platform APIs to build AR apps on Android, iOS, Unity, and Web.

details : [https://developers.google.com/ar](https://developers.google.com/ar)

## Using Firebase database

This section show Firebase`s manual.
Using Firebase Realtime database, the client code can directly access with database.

Manual

1.Necessity
-Google account
-Android application to connect(Sign in xml, activity)

2.Process
-

## Conclusion

In conclusion, Gachon AR Navigation is a useful and convenient mobile app for navigating the Gachon University campus. Whether you are a student, faculty member, or visitor, this app will help you easily find your way around campus and discover all that Gachon University has to offer.
