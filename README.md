# Bi Directional Viewpager easy RTL support    [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

A ``ViewPager Android library`` written in ``kotlin`` that supports right to left for RTL locales with a ````natively  ViewPager```` that can be used with both :
### ``TabLayout`` And ``BottomNavigation``

### How to import in Your Android Studio Project
The library is published on ``jCenter`` you need to add the following dependency to your ```build.gradle ``` file.
```
dependencies {
    implementation 'com.code95.bidirectionalviewpager:bidirectionalviewpager:0.0.1'
}
```

### Sample Output for both TabLayout and BottomNavigation
![alt tag](https://media.giphy.com/media/Mc0nhTj1a71iIlDJsY/giphy.gif)
![alt tag](https://media.giphy.com/media/kc0w3xEs5SfjYgztQj/giphy.gif)


## How to use (You can check attached ``Sample Project``)


Send `isRtlOriented` = ``true or false`` to the ``RTLPagerAdapter`` as a parameter.

``Tab`` is Helper class that contains the Tab with (Title And Fragment) `` OR `` the Tab with (Menu Item resource ID And Fragment).

#### -First Using with TabLayout 

``tabs`` is our BiDirectionalTabLayout
``view_pager`` is our BiDirectionalViewPager

````
var adapter = BiDirectionalPagerAdapter(supportFragmentManager, isRtlOriented, view_pager)
view_pager.adapter = adapter
tabs.setupWithViewPager(view_pager)
```` 

#### -Second Using with BottomNavigation 

``bottom_navigation`` is our BiDirectionalBottomNavigation
``view_pager`` is our BiDirectionalViewPager

````
var adapter = BiDirectionalPagerAdapter(supportFragmentManager, isRtlOriented, view_pager)
view_pager.adapter = adapter
adapter.setupWithBottomNavView(bottom_navigation)
```` 

Then we can add tab, tabs or remove tab using helper methods:

```addTab(tab : Tab())```
```addTabs(tabs : MutableList<Tab>)```
```removeTab(position : Int)```



#### Libirary is designed and developed by 
### [Code95](https://github.com/Code95) Mobile Team. 

[![Code95][1]][2]

[1]:  https://code95.com/wp-content/uploads/code95-logo-small.png
[2]:  https://code95.com/
