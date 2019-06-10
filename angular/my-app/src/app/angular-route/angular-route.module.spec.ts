import { AngularRouteModule } from './angular-route.module';

describe('AngularRouteModule', () => {
  let angularRouteModule: AngularRouteModule;

  beforeEach(() => {
    angularRouteModule = new AngularRouteModule();
  });

  it('should create an instance', () => {
    expect(angularRouteModule).toBeTruthy();
  });
});
