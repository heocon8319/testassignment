# testassignment

Assignment for Mobile Developer
A simple application built to demonstrate the use of modern android architecture component with MVVM
Architecture.
The Application is using the mock api ( created from json file) to showing news.

Apply SOLID principles
MVVM: Structure to which mvvm design pattern can be applied

Build With:

Kotlin - Programming language for Android
Hilt-Dagger - Standard library to incorporate Dagger dependency injection into an Android
application.
Retrofit - A type-safe HTTP client for Android and Java.
Coroutines - For asynchronous.
LiveData - Data objects that notify views when the underlying database changes.
ViewModel - Stores UI-related data that isn't destroyed on UI changes.
ViewBinding - Generates a binding class for each XML layout file present in that module and allows
you to more easily write code that interacts with views.
Junit, Mockito- Write unit test.
The application has finished features:

The application is a simple Android application which is written by Java/Kotlin.
The application is able to retrieve the news information from mock API.
The application is able to support caching mechanism so as to prevent the app from generating a
bunch of API requests.
The application is able to manage caching mechanism & lifecycle.
The application is able to handle failures.
The application is able to support the disability to scale large text for who can't see the text
clearly.
The application is able to go back and forth between the list and details creen
The application is able to apply pagination mechanism.
The application is able to have all good UI must-haves such as smooth animations and consistent UI
elements.

**
I wrote base adapter, base model to service: When there are more upcoming event types, the code should adapt
well without requiring too much changes.
