# Django
## create Django project steps:

	1. Create a Django project:
		> django-admin startproject [name-of-project]
	2. Create inside the project folder an "app"
		> python manage.py startapp [app-name]
	3. Run your project on server:
		> python manage.py runserver
	4. URL Dispatcher:

		a. Create a 'view.py' inside app:
			E.g. index view...
			>>>
				from django.shortcuts import render
				from django.http import HttpResponse

				def index(request):
					return HttpResponse('<h1>Hello Explorers!</h1>')

		b. Create 'urls.py' inside each app:
			>>>
				from django.conf.urls import url
				from . import views

				urlpatterns = [
				    url(r'^$', views.index),
				]

		c. Change the import and add 'include'
			>>>
				from django.conf.urls import include, url
				from django.contrib import admin

				urlpatterns = [
				    url(r'^admin/', admin.site.urls),
				    # localhost:8000 will go here
				    url(r'^', include('main_app.urls')),
				]

	5. Database settings:
		- https://docs.djangoproject.com/en/1.9/intro/tutorial02/
		- https://docs.djangoproject.com/en/1.9/ref/settings/#std:setting-DATABASES
			>>>
				DATABASES = {
				    'default': {
				        'ENGINE': 'django.db.backends.mysql',
				        'NAME': 'test',
				        'USER': 'root',
				        'PASSWORD': 'password',
				        'HOST': '/var/run/mysql',
				        'PORT': '3306',
				    }
				}


