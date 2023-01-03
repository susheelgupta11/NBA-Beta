package org.nba.upload




import spock.lang.*

@TestFor(ManualUploadController)
@Mock(ManualUpload)
class ManualUploadControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.manualUploadInstanceList
            model.manualUploadInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.manualUploadInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def manualUpload = new ManualUpload()
            manualUpload.validate()
            controller.save(manualUpload)

        then:"The create view is rendered again with the correct model"
            model.manualUploadInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            manualUpload = new ManualUpload(params)

            controller.save(manualUpload)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/manualUpload/show/1'
            controller.flash.message != null
            ManualUpload.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def manualUpload = new ManualUpload(params)
            controller.show(manualUpload)

        then:"A model is populated containing the domain instance"
            model.manualUploadInstance == manualUpload
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def manualUpload = new ManualUpload(params)
            controller.edit(manualUpload)

        then:"A model is populated containing the domain instance"
            model.manualUploadInstance == manualUpload
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/manualUpload/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def manualUpload = new ManualUpload()
            manualUpload.validate()
            controller.update(manualUpload)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.manualUploadInstance == manualUpload

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            manualUpload = new ManualUpload(params).save(flush: true)
            controller.update(manualUpload)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/manualUpload/show/$manualUpload.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/manualUpload/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def manualUpload = new ManualUpload(params).save(flush: true)

        then:"It exists"
            ManualUpload.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(manualUpload)

        then:"The instance is deleted"
            ManualUpload.count() == 0
            response.redirectedUrl == '/manualUpload/index'
            flash.message != null
    }
}
