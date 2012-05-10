#include "basic.h"

IMPLEMENT_DYNAMIC_CLASS(BasicFrame,wxPanel);

BasicFrame::BasicFrame (wxWindow* parent,
                        wxWindowID id,
                        const wxPoint & pos,
                        const wxSize & size,
                        long style,
                        const wxString& name)
{
  Create(parent, id, pos, size, style, name);
}

bool BasicFrame::Create(wxWindow* parent,
                        wxWindowID id,
                        const wxPoint & pos,
                        const wxSize & size,
                        long style,
                        const wxString& name)
{
  if ( !wxPanel::Create(parent, id, pos, size, style, name) )
    return false;

  ratio = 1;
  translate = wxRealPoint(0.0,0.0);
  mousePosition = wxPoint(0,0);

  this->Connect(wxEVT_MOTION, wxMouseEventHandler(BasicFrame::OnMouseMotion));
  this->Connect(wxEVT_MOUSEWHEEL, wxMouseEventHandler(BasicFrame::OnMouseWheel));
  this->Connect(wxEVT_SIZE, wxSizeEventHandler(BasicFrame::OnSize));

  return true;
}
 
void BasicFrame::OnMouseMotion (wxMouseEvent& event)
{
  wxPoint p;
  event.GetPosition (&p.x, &p.y);

  if (event.Dragging()){
    wxPoint dif = p - mousePosition;
    if (translate == wxRealPoint(0,0)){
      translate = wxRealPoint(dif.x, dif.y);
    }else{
      translate = translate + wxRealPoint(dif.x, dif.y);
    }
    Refresh();
  }
  mousePosition = p;
}

void BasicFrame::OnMouseWheel (wxMouseEvent& event)
{
  //get mouse position in the screen (in the frame to be precise)
  wxPoint screen;
  event.GetPosition (&screen.x, &screen.y);

  //get the device context, apply the current transformations
  wxPaintDC dc(this);
  dc.SetUserScale (ratio, ratio);
  dc.SetDeviceOrigin (translate.x, translate.y);

  //transform the mouse position in the screen space to the logical space
  wxRealPoint mouseLogical;
  mouseLogical.x = dc.DeviceToLogicalX (screen.x);
  mouseLogical.y = dc.DeviceToLogicalY (screen.y);

  //calculate and apply the new user scale in the device context
  if (event.GetWheelRotation() > 0){
    ratio += ratio*.1;
  }else{
    ratio -= ratio*.1;
  }
  dc.SetUserScale (ratio, ratio);

  //transform the mouse logical position to the new screen space (scale change)
  wxRealPoint mouseScreenAfter;
  mouseScreenAfter.x = dc.LogicalToDeviceX (mouseLogical.x);
  mouseScreenAfter.y = dc.LogicalToDeviceY (mouseLogical.y);

  //calculate the difference between the two mouse screen positions
  wxRealPoint dif = wxRealPoint(screen.x,screen.y) - mouseScreenAfter;

  //the difference is the amount to compensate when a change in scale is applied
  translate = translate + dif;

  event.GetPosition (&mousePosition.x, &mousePosition.y);
  Refresh();
}

void BasicFrame::OnSize (wxSizeEvent& event)
{
  Refresh();
}