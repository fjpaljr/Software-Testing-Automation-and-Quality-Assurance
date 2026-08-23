# Software-Testing-Automation-and-Quality-Assurance
These files demonstrate my ability to create unit tests using code to uncover errors, analyze various approaches to software testing based on requirements, and apply appropriate testing strategies to meet requirements.

How can I ensure that my code, program, or software is functional and secure?
I made sure my code worked by writing JUnit tests that covered both the normal use cases and the edge cases, like invalid input, null values, and fields that went over their character limit. I also validated input at the point of creation instead of trusting it would be clean later, which caught problems early and kept bad data out of the system.

How do I interpret user needs and incorporate them into a program?
I took the stated requirements, like field limits and required behaviors for the Contact services, and translated each one directly into a rule in the code and a matching test. Breaking the requirements down piece by piece made it a lot easier to check that I had actually built what was asked for instead of just something close to it.

How do I approach designing software?
I start by breaking a problem into small pieces before writing any code, figuring out what each class actually needs to do on its own. For this project that meant designing the model classes first and then building the service layer around them once I understood the rules each one had to follow.
