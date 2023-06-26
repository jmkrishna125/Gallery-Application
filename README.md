# Gallery-Application

This is a simple gallery app that displays a collection of images using a grid view. Users can tap on an image to view and swipe  it in full screen.

# Technologies Used

Android Studio

Kotlin Programming Language

Glide library for image loading and caching

# Usage

Launch the app on your Android device or emulator.

Images will display in the grid layout.

Tap on an image to view it in full-screen mode.

Swipe left or right to navigate between images in full-screen view.

# Code Structure

MainActivity.kt: Contains the main activity class that displays the grid view of images using GalleryFragment and handles user interactions.

FullScreenViewActivity.kt: Represents the activity for displaying the full-screen view of an image with its title and description.

GalleryAdapter.kt: Implements the adapter for filling the grid view with images using the GridView component.

FullScreenViewAdapter.kt: Implements the adapter for displaying the images, titles, and descriptions in the full-screen view using a ViewPager component.

GalleryData.kt: Defines the data class for storing gallery item information, including the title, description, and image URL.

activity_main.xml: Layout file for the main activity containing the GridView component.

fullscreen_viewpager.xml: Layout file for the full-screen view activity containing the ViewPager component.

grid_item.xml: Layout file for the grid item in the grid view, displaying the image using an ImageView.

fragment_full_screen.xml: Layout file for the full-screen view of an image, displaying the image, title, and description using various UI components.

nasa_details.json: JSON file containing the gallery data in the form of image URLs, titles, and descriptions.

# Screenshots
![Grid View Gallery](https://github.com/jmkrishna125/Gallery-Application/assets/137467710/4b3fc989-f747-40c5-8151-9a5b9e95f114)

![Full Screen View](https://github.com/jmkrishna125/Gallery-Application/assets/137467710/be1a19bc-25cc-468e-86d7-c6f24a701268)







