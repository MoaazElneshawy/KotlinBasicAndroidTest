# KotlinBasicAndroidTest
basic android instrumentation test 

Tips:
1- Instrumentation tests require an InstrumentationTestRunner, which allows the test to execute on a device or emulator.
    ex: @RunWith(AndroidJUnit4::class)
        class CalculatorTests {}

2- ActivityScenarioRule comes from the AndroidX Test library. It tells the device to launch an activity specified by the developer.
    ex: @get:Rule() 
        val activity = ActivityScenarioRule(MainActivity::class.java)

3- The function withId() returns a ViewMatcher that is the UI component with the ID that is passed to it.
   onView() returns a ViewInteraction, which is an object that we can interact with as if we were controlling the device ourselves.
   To input some text, you call perform() on the ViewInteraction. Then, perform() takes a ViewAction object.
   There are a number of methods that return a ViewAction but for now we are going to use the typeText() method.
   
   **.perform(ViewActions.closeSoftKeyboard())** after writing on editText is needed on smaller devices,
   and also for avoiding test fails because of PerformException:Error single click
   
   
